package com.changan.designpattern.pattern.behavior.visitor;

/**
 * 用户基础数据
 *
 * @author zab
 * @date 2024/11/12 22:50
 */
public class UserBaseData implements ICarBaseData{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
