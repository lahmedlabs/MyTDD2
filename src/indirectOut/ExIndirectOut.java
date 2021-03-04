package indirectOut;

public class ExIndirectOut {
    private Greeting something;
    public void doIt(String str){
        if(str == "Hello"){
            something.say("Hello World!");
        }
        else something.say("Good Bye!");
    }
}
