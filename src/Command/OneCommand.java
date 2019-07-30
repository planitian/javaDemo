package Command;

public class OneCommand extends BaseCommand {

    public OneCommand(BaseReceiver baseReceiver) {
        super(baseReceiver);
    }

    @Override
    public void execute() {
            this.baseReceiver.word();
    }
}
