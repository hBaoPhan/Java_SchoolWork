package protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private ActionType actionType;
    private Object data;

    public Request(ActionType actionType, Object data) {
        this.actionType = actionType;
        this.data = data;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Object getData() {
        return data;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
