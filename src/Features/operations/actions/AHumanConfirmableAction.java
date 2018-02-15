package Features.operations.actions;

/**
 * Created by Tobias on 15.02.2018.
 */

public abstract class AHumanConfirmableAction implements IAction {

    protected String description;

    public AHumanConfirmableAction() {
        // Nothing to do here
    }

    public AHumanConfirmableAction(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public EActionType getType() { return EActionType.HUMAN_CONFIRMABLE; }

}
