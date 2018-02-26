package converter;

import converter.core.Dialog;

/**
 * @Author Karol Meksuła
 * 26-02-2018
 **/

public class Main {
    public static void main(String[]args){
        while (!Dialog.from.equals("q")){
            Runnable runnable = () -> {
                try {
                    new Dialog().conversationFlow();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            runnable.run();
        }
    }
}
