package com.zab.springboot.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
/**
 * 怎样使用自定义的scope
 *
 * @author zab
 * @date 2022/5/8 21:45
 */
@Scope("threadScope")
@Service
public class ScopeService {

}
