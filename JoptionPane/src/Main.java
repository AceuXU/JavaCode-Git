import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // JOptionPane = pop up a standard dialog box that prompts users for a value
        // or informs them of something.

//        JOptionPane.showMessageDialog(null, "THis is useless info bruh","title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, " no info :D","title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "mmm something ","title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Call tech support","title", JOptionPane.ERROR_MESSAGE);

//       int question = JOptionPane.showConfirmDialog(null,"bro do you even know how to code?","title XD",JOptionPane.YES_NO_OPTION);

//       String name  =JOptionPane.showInputDialog("tell me your namee xd");
//       System.out.println(name);

        String [] response = {"No","yes me noob","i will get better"};

        JOptionPane.showOptionDialog(null, "are you coding noob","coding question",
                JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,response,1);


        //        while (true){
        //            JOptionPane.showMessageDialog(null, "your pc has virus","title", JOptionPane.WARNING_MESSAGE);
    }
}

