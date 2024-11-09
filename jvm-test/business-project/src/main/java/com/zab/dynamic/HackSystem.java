package com.zab.dynamic;

import sun.reflect.CallerSensitive;

import java.io.*;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Properties;

public class HackSystem {
    public final static InputStream in = System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public final static PrintStream out = new PrintStream(buffer);

    public final static PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static int identityHashCode(Object x) {
        return System.identityHashCode(x);
    }
    
    
    /*------------------------------------------*/

    private static volatile SecurityManager security = null;

    public static void setIn(InputStream in) {
        System.setIn(in);
    }

    public static void setOut(PrintStream out) {
        System.setOut(out);
    }

    public static void setErr(PrintStream err) {
        System.setErr(err);
    }

    private static volatile Console cons = null;
    public static Console console() {
        if (cons == null) {
            synchronized (System.class) {
                cons = sun.misc.SharedSecrets.getJavaIOAccess().console();
            }
        }
        return cons;
    }

    public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }


    public static native long nanoTime();

    private static Properties props;

    public static Properties getProperties() {
        SecurityManager sm = getSecurityManager();
        if (sm != null) {
            sm.checkPropertiesAccess();
        }

        return props;
    }

    public static String lineSeparator() {
        return lineSeparator;
    }

    private static String lineSeparator;

    public static void setProperties(Properties props) {
        System.setProperties(props);
    }

    public static String getProperty(String key) {
        return System.getProperty(key);
    }

    public static String getProperty(String key, String def) {
        return System.getProperty(key, def);
    }

    public static String setProperty(String key, String value) {
        return System.setProperty(key, value);
    }

    public static String clearProperty(String key) {
        return System.clearProperty(key);
    }


    public static String getenv(String name) {
       return System.getenv(name);
    }


    public static java.util.Map<String,String> getenv() {
        return System.getenv();
    }

    public static void exit(int status) {
        System.exit(status);
    }

    public static void gc() {
        System.gc();
    }

    public static void runFinalization() {
        System.runFinalization();
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        System.runFinalizersOnExit(value);
    }

    @CallerSensitive
    public static void load(String filename) {
        System.load(filename);
    }
    @CallerSensitive
    public static void loadLibrary(String libname) {
        System.loadLibrary(libname);
    }

    public static String mapLibraryName(String libname){
        return System.mapLibraryName(libname);
    }

}
