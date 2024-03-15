package model;
import java.util.*;

public class Gate extends BaseModel{

    private String gateName;

    private Operator operator;

    private GateType gateType;

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {

        this.gateName = gateName;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
