package com.zab.designpattern.pattern.behavior.visitor;

/**
 * 卡基础数据
 *
 * @author zab
 * @date 2024/11/12 22:50
 */
public class SimData implements ICarBaseData{
    private String simNo;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
