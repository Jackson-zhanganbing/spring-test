package com.zab.manualmvc.core;

import com.zab.manualmvc.annotation.Autowired;
import com.zab.manualmvc.annotation.Controller;
import com.zab.manualmvc.annotation.RequestMapping;
import com.zab.manualmvc.annotation.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatchServletSix extends HttpServlet {

    private List<String> clazzNameList = new ArrayList<>();
    private Map<String, Object> clazzMap = new HashMap<>(16);
    private Map<String, Object> urlMap = new HashMap<>(16);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        url = url.substring(url.indexOf("mvc/")).replaceAll("mvc", "");
        //根据url映射调用方法
        Object result = this.dispatchUrl(url);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(result.toString());
    }

    private Object dispatchUrl(String url) {
        Method method = (Method) urlMap.get(url);
        String clazzName = method.getDeclaringClass().getCanonicalName();
        try {
            return method.invoke(clazzMap.get(clazzName), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("---------init-----------");
        //加载指定目录下的所有文件
        loadFiles("com/zab/manualmvc");
        System.out.println(clazzNameList.toString());
        //把有注解的都实例化，放到map中备用，key：.class，value：obj
        instanceClass();
        System.out.println(clazzMap.toString());
        //ioc,路由映射
        urlMapping();
        System.out.println(urlMap.toString());
    }


    private void urlMapping() {
        for (Map.Entry entry : clazzMap.entrySet()) {
            Object object = entry.getValue();
            Class clazz = object.getClass();
            if (clazz.isAnnotationPresent(Controller.class)) {
                RequestMapping controllerRequestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                String conMapping = controllerRequestMapping.value()[0];

                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                        String methodMapping = requestMapping.value()[0];
                        urlMap.put(conMapping + methodMapping, method);
                    }
                }


                //ioc
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(Autowired.class)) {
                        String controllerName = field.getDeclaringClass().getName();
                        String typeName = field.getType().getTypeName();
                        try {
                            field.set(clazzMap.get(controllerName), clazzMap.get(typeName));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void instanceClass() {
        for (String clazzName : clazzNameList) {
            Class clazz = null;
            Object obj = null;
            try {
                clazz = Class.forName(clazzName);
                if (clazz.isAnnotationPresent(Controller.class) || clazz.isAnnotationPresent(Service.class)) {

                    obj = clazz.getConstructor().newInstance();
                    clazzMap.put(clazzName, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loadFiles(String basePath) {
        URL url = getClass().getClassLoader().getResource(basePath);
        String fileUrl = url.getFile();
        File[] files = new File(fileUrl).listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                String subFilePath = basePath + "/" + file.getName();
                loadFiles(subFilePath);
            } else {
                String pointUrl = basePath.replaceAll("/", ".");
                String needUrl = (pointUrl + "." + file.getName()).replaceAll(".class", "");
                clazzNameList.add(needUrl);
            }
        }
    }
}
