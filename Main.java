package sample;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.INACTIVE;
import org.w3c.dom.*;

import javax.naming.LinkException;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.Text;
import java.util.*;
import java.util.logging.Level;

public class Main extends Application {
    int numms;
    @Override
    public void start(Stage Stage) throws Exception{
        Stage.setTitle("Prime & Essential Implicants");
        AnchorPane root=new AnchorPane( );



        Label none = new Label();
        Label view=new Label( "Number Of Variables");
        view.setLayoutY(5);
        view.setLayoutX(5);
        TextField numVar = new TextField("");
        numVar.setAlignment(Pos.CENTER);
        numVar.setLayoutX(5);
        numVar.setLayoutY(30);

        none.setLayoutX(5);
        none.setLayoutY(60);
        numVar.setPrefColumnCount(3);

        Label minlabel=new Label("Min Terms");
        minlabel.setLayoutX(5);
        minlabel.setLayoutY(80);
        TextField min =new TextField("");
        min.setLayoutX(5);
        min.setLayoutY(105);
        min.setPrefColumnCount(55);

        min.setPrefHeight(80);
        min.setAlignment(Pos.TOP_LEFT);

        Label noneMin=new Label("");
        noneMin.setLayoutY(190);
        noneMin.setLayoutX(5);
        root.getChildren().add(noneMin);

        Label dont=new Label("Don't Care Element");
        dont.setLayoutX(5);
        dont.setLayoutY(230);

        TextField DonElemet=new TextField();
        DonElemet.setLayoutX(5);
        DonElemet.setLayoutY(255);
        DonElemet.setPrefHeight(80);
        DonElemet.setPrefColumnCount(55);
        DonElemet.setAlignment(Pos.TOP_LEFT);
        Label noneDont=new Label("");
        noneDont.setLayoutX(5);
        noneDont.setLayoutY(340);
        root.getChildren().addAll(dont,DonElemet,noneDont);

        Button btn=new Button("OK");
        btn.setPrefSize(200,50);
        btn.setLayoutX(820);
        btn.setLayoutY(780);

        Label finall=new Label("") ;
        finall.setLayoutX(850);
        finall.setLayoutY(680);
        Label essential=new Label("The Function ");
        essential.setLayoutY(640);
        essential.setLayoutX(5);
        essential.setStyle
                (
                        "-fx-font-family: \"arial\";"
                                + "-fx-font-size: 20px;"
                                + "-fx-font-style: normal;"
                                + "-fx-font-weight: bolder;"
                );        root.getChildren().add(essential);
        view.setStyle
                (
                        "-fx-font-family: \"arial\";"
                                + "-fx-font-size: 20px;"
                                + "-fx-font-style: normal;"
                                + "-fx-font-weight: bolder;"
                );

        minlabel.setStyle
                (
                        "-fx-font-family: \"arial\";"
                                + "-fx-font-size: 20px;"
                                + "-fx-font-style: normal;"
                                + "-fx-font-weight: bolder;"
                );
        root.setStyle(
                "-fx-font-family: \"arial\";"+
                "-fx-background-color:\"#e3dfe3\";"
        );
        dont.setStyle
                (
                        "-fx-font-family: \"arial\";"
                                + "-fx-font-size: 20px;"
                                + "-fx-font-style: normal;"
                                + "-fx-font-weight: bolder;"
                );

        //finall.setLayoutX(100);
        //   finall.setLayoutY(500);
        TextArea fucn=new TextArea("");
        fucn.setDisable(false);
        fucn.setLayoutY(680);
        fucn.setPrefColumnCount(54);
        fucn.setMaxHeight(150);
        fucn.setLayoutX(5);
        root.getChildren().addAll(finall,fucn);
        TextArea done =new TextArea();

        done.getScrollLeft();

        done.setLayoutX(5);
        done.setLayoutY(400);

        done.setEditable(false);

        done.setScrollTop(10);
        done.setStyle("-fx-text-inner-color: black" );

        done.setPrefColumnCount(54);
        root.getChildren().addAll(done);

        Label prime=new Label("Prime Implicants");
        prime.setLayoutX(850);
        prime.setLayoutY(70);
        func.
        prime.setStyle
                (
                        "-fx-font-family: \"arial\";"
                                + "-fx-font-size: 20px;"
                                + "-fx-font-style: normal;"
                                + "-fx-font-weight: bolder;"
                );
       // root.getChildren().addAll(prime);


        EventHandler<ActionEvent> eventt = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

                ar war=new ar(done);

                if(validate(numVar,none,min,noneMin,DonElemet,noneDont,war)){
                    war.printPrimitive(done,finall,fucn);

                }

            }

        };
        fucn.setScrollTop(5);
        fucn.setScrollLeft(5);
        btn.setOnAction(eventt);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(min,minlabel,btn);
        root.getChildren().add(view);
        root.getChildren().addAll(none,numVar);
        Scene sc = new Scene(root, 1100, 900);
        //  sc.getOnScroll();
        //sc.getOnScrollStarted();
        sc.getOnScrollFinished();
        Stage.setScene(sc);
        Stage.show();

    }


    public static void main(String[] args) {

        launch(args);



    }



    boolean validate(TextField numVar,Label none ,TextField min ,Label noneMin,TextField DontElement ,Label noneDont,ar war){
        String num=numVar.getText();
        num=shift(num);
        boolean flag=true;
        if(shift(numVar.getText())==""){
            none.setTextFill(Color.RED);
            none.setText("This field is empty");
            flag=false;
        }else {
            none.setText("");
        }
        if(shift(min.getText())==""){
            noneMin.setText("This Field Is Empty");
            noneMin.setTextFill(Color.RED);

            return false;
        }else {
            noneMin.setText("");
        }
        /*if(!flag){
            return false;
        }*/
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)>'9'||num.charAt(i)<'0'){
                none.setTextFill(Color.RED);
                none.setText("0 to 26 only");
                noneMin.setText("");

                return false;

            }
        }

        if (num == "") return false;
        int numm = Integer.parseInt(num);
        if (numm > 26 || numm < 0) {
            none.setTextFill(Color.RED);
            none.setText("0 to 26 only");
            noneMin.setText("");
            return false;
        } else {
            none.setText("");
            noneMin.setText("");
        }
        int numOfVariables = numm;
        numms=numm;
        num = min.getText();

        num = shift(num);
        if (num == "") return false;

        for (int i = 0; i < num.length(); i++) {
            if ((num.charAt(i) != ' ' && (num.charAt(i) > '9' || num.charAt(i) < '0'))) {

                noneMin.setText("Numbers only and Range from 0 TO " + (Math.pow(2, numOfVariables) - 1));
                noneMin.setTextFill(Color.RED);
                return false;
            }

        }
        String y[] = num.split(" ");
        int arr[] = new int[y.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(y[i]);
            if (arr[i] < 0 || arr[i] > (Math.pow(2, numOfVariables) - 1)) {
                noneMin.setText("Numbers only and Range from 0 TO " + (Math.pow(2, numOfVariables) - 1));
                noneMin.setTextFill(Color.RED);
                return false;
            }
        }


        num=shift(DontElement.getText());
        if(num==""){
            war.zayady2(numOfVariables,arr);
            return true;
        }






        for(int i=0;i<num.length();i++){
            if((num.charAt(i)!=' '&&(num.charAt(i)>'9'||num.charAt(i)<'0'))){

                noneDont.setText("Numbers only and Range from 0 TO "+(Math.pow(2,numOfVariables)-1));
                noneDont.setTextFill(Color.RED);
                return  false;
            }

        }

        String yy[]=num.split(" ");
        int arr2[]=new int [yy.length];
        for(int i=0;i<arr2.length;i++){
            arr2[i]=Integer.parseInt(yy[i]);
            if(arr2[i]<0||arr2[i]>(Math.pow(2,numOfVariables)-1)){
                noneDont.setText("Numbers only and Range from 0 TO "+(Math.pow(2,numOfVariables)-1));
                noneDont.setTextFill(Color.RED);
                return false;
            }
        }
        noneDont.setText("");

        war.section(numOfVariables,arr,arr2);
        return true;

    }


    private String shift(String x){
        int count=0;
        String y="";
        boolean flag=false;
        int be=0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)!=' '){
                be=i;
                break;
            }
        }
        int end=-1;
        for(int i=x.length()-1;i>=0;i-- ){
            if(x.charAt(i)!=' '){
                end=i;
                break;
            }
        }
        if(end==-1){
            return "";
        }
        for(int i=be;i<=end;i++){
            if(x.charAt(i)!=' '){
                y+=x.charAt(i);
            }
            else if(x.charAt(i)==' '&&i!=end&&x.charAt(i+1)!=' '){
                y+=' ';
            }
        }
        System.out.println(y);
        return y;

    }

}


class ar {

    public ways x = new ways();
    public HashSet h =new HashSet();
    public HashSet merge=new HashSet();
    public HashSet DontCare=new HashSet();
    public ArrayList<LinkedList> death = new ArrayList<LinkedList>();
    public ArrayList<LinkedList> first = new ArrayList<LinkedList>();
    public ArrayList<LinkedList> TWICE = new ArrayList<LinkedList>();
    Stack<String> theEndOfWar = new Stack<>();
    Stack<Integer> theBeginOfWar=new Stack<>();
    Pane tt;

    String theWar="";
    //******************************************************************************************************
    public void section(int n,int arr[],int arr2[]){
        x.num=n;
        for(int i=0;i<arr.length;i++){
            h.add(arr[i]);
        }
        if(arr2!=null){
            for(int i=0;i<arr2.length;i++){
                DontCare.add(arr2[i]);
            }}

        mergrHash();
        differ();
    }
    public void zayady2(int n,int arr[]){
        x.num=n;
        for(int i=0;i<arr.length;i++){
            h.add(arr[i]);
        }
        mergrHash();
        differ();
    }

    TextArea done =new TextArea();
    ar(TextArea done){
        this.done=done;
    }

    //******************************************************************************************************
    void printPrimitive(TextArea finall,Label need,TextArea func){
        Stack<String >one=new Stack<String>();
        // Stack<String >two=new Stack<String>();
        String temp="Result \n";
        Stack <Integer>two=new Stack<Integer>();

        //System.out.println("RESULT");
        Stack <String>NUME=new Stack<>();
        Stack <String>LETTERS=new Stack<>();
        while (!theBeginOfWar.empty()){
            System.out.println(theBeginOfWar.peek());
            temp+=theBeginOfWar.peek();
            temp+="\n";
            String u=Integer.toString(theBeginOfWar.pop());
            NUME.add(u);
            two.push(Integer.parseInt(u));
        }
        while (!theEndOfWar.empty()){

            System.out.println(theEndOfWar.peek());
            temp+=theEndOfWar.peek();
            temp+="\n";
            String y= theEndOfWar.pop();
            NUME.add(y);
            one.push(y);
            //  theEndOfWar.pop();
        }
        String r=finall.getText();
        //finall.setText(r+"\n \n \n \n "+temp);
        theWar+="\n"+temp;
        Stack<String>i1=x.justice2(two,finall,theWar);
        Stack<String>i2=x.justice(one,finall);
        while (!i1.empty()){
            i2.add(i1.pop());
        }
        Essential d=new Essential(h,NUME,i2,finall,need,func);

    }
    //******************************************************************************************************
    void  mergrHash(){
        if(DontCare==null){
            merge=h;
        }else {
            Iterator<Integer> t=h.iterator();
            for(int i=0;i<h.size();i++){
                merge.add(t.next());
            }
            Iterator <Integer> w=DontCare.iterator();
            for(int i=0;i<DontCare.size();i++){
                merge.add(w.next());
            }
        }
        System.out.println("merge is "+merge);
    }
    //******************************************************************************************************
    void differ() {
        for (int i = 0; i <= x.num; i++) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            Iterator<Integer> t = merge.iterator();
            for (int j = 0; j < merge.size(); j++) {
                int here = t.next();
                if (ones(here) == i) {
                    temp.add(here);
                }
            }
            death.add(temp);
        }
        death=trim(death);
        printcalss();
        firstone();
    }

    private ArrayList <LinkedList> trim (ArrayList<LinkedList>x){
        ArrayList <LinkedList> ss=x;
        for(int i=0;i<ss.size();i++){
            LinkedList<Integer> temp = ss.get(i);

            if(temp.size()==0){
                ss.remove(i);
                i--;
            }else{
                break;
            }
        }
        for(int i=ss.size()-1;i>=0;i--){
            LinkedList<Integer> temp = ss.get(i);
            if(temp.size()==0){
                ss.remove(i);

            }else {
                break;
            }
        }
        return  ss;
    }


    //******************************************************************************************************
    private int ones(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 2;
            num /= 2;
        }
        return count;
    }



    //******************************************************************************************************
    public void printcalss() {
        String r="";

        for (int i = 0; i < death.size(); i++) {
            r+=("contain<" + i + ">one\n");
            System.out.println("contain<" + i + ">one\n");
            LinkedList<Integer> temp = death.get(i);
            Iterator<Integer> k = temp.iterator();
            for (int g = 0; g < temp.size(); g++) {
                int ee=k.next();
                r+=ee+"\n";
                // theWar+=(ee+"\n");
                System.out.println(ee);
            }
            theWar+=r+"\n ";
            r="";
            System.out.println("*************************************");
        }
        //done.setText(r+"\n \n \n \n \n \n ");
        theWar+="\n \n \n \n \n \n ";
        System.out.println("\n \n \n ");


    }

    //******************************************************************************************************
    public void printclass2() {

        for (int i = 0; i < TWICE.size(); i++) {
            LinkedList<String> temp = TWICE.get(i);
            Iterator<String> k = temp.iterator();
            for (int j = 0; j < TWICE.get(i).size(); j++) {
                String r=k.next();
                theWar+=r+"\n";
                System.out.println(r);
                //String tttt=done.getText();
                //  theWar+=tttt+("\n")+r;
                // done.setText(tttt+"\n"+r);
            }
            // String tt=done.getText();
            //done.setText(tt+"\n"+"______________"+"\n");
            theWar+= ""+"______________"+"\n";
            System.out.println("*********");
        }
        String tt="";
        // tt+=done.getText();
        // tt+=("\n \n \n \n \n \n \n");
        // done.setText(tt);
        theWar+=("\n \n \n \n \n ");
        System.out.println("\n \n \n ");
    }
//******************************************************************************************************
    public void firstone() {
        if (death.size() > 1) {
            boolean arra[] = new boolean[death.get(0).size()];
            boolean arrb[] = new boolean[death.get(1).size()];

            LinkedList<String> temp = tL(death.get(0), death.get(1), arra, arrb);

            if (temp.size() != 0) {
                TWICE.add(temp);
            }
            getPrimitive(arra, death.get(0));
            if(death.size()==2){
                getPrimitive(arrb,death.get(1));
            }
            for (int i = 1; i < death.size() - 1; i++) {
                arra = arrb;
                arrb = new boolean[death.get(i + 1).size()];
                LinkedList<String> t = tL(death.get(i), death.get(i + 1), arra, arrb);
                TWICE.add(t);
                getPrimitive(arra, death.get(i));
                if(i==death.size()-2){
                    getPrimitive(arrb,death.get(i+1));
                }
            }

        }else if(death.size()==1) {
            boolean arra[] = new boolean[death.get(0).size()];
            getPrimitive(arra,death.get(0));
        }
        trim(TWICE);
       printclass2();
        THEEND(TWICE);
    }
    //******************************************************************************************************
    private void getPrimitive(boolean arr[], LinkedList<Integer> x) {

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                theBeginOfWar.push((x.get(i)));
            }
        }

    }
    //******************************************************************************************************
    private  void getprimitiveHighr(boolean arr[],LinkedList<String> x){
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                theEndOfWar.push((x.get(i)));
            }
        }
    }
    //******************************************************************************************************
    public LinkedList tL(LinkedList<Integer> a, LinkedList<Integer> B, boolean arra[], boolean arrb[]) {
        LinkedList<String> fine = new LinkedList<String>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                int q=B.get(j);
                int w=a.get(i);
                int e=B.get(j) - a.get(i);
                if (multiple(B.get(j) - a.get(i)) && B.get(j) > a.get(i)) {
                    arra[i] = true;
                    arrb[j] = true;
                    if (!fine.contains(ss(a.get(i), B.get(j) - a.get(i)))) {
                        fine.add(ss(a.get(i), B.get(j) - a.get(i)));
                    }
                }
            }
        }
        return fine;
    }
    //******************************************************************************************************
    public String ss(int num, int num2) {
        String x = Integer.toString(num);
        String y = Integer.toString(num2);
        return x  + "[" + num2 + "]";
    }

    //******************************************************************************************************
    public boolean multiple(int num) {
        int z = x.num;
        for (int i = 0; i <= z + 2; i++) {
            if (Math.round(Math.pow(2, i)) == num) {
                return true;
            }
        }
        return false;

    }
    //******************************************************************************************************
    private boolean same(String x, String y) {

        int num1=0;
        int num2=0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='['){
                num1=i;
                break;
            }
        }
        for(int i=0;i<y.length();i++){
            if(y.charAt(i)=='['){
                num2=i;
                break;
            }
        }
        String one="";
        String two ="";
        for(int i=num1;i<x.length();i++){
            one+=x.charAt(i);
        }
        for(int i=num2;i<y.length();i++){
            two+=y.charAt(i);
        }
        return one.equals(two);
    }


    //******************************************************************************************************
    public String Mix(int num, String y) {
        int x = 0;
        for (int i = 0; i < y.length(); i++) {
            if (y.charAt(i) == '[') {
                x = i + 1;
                break;
            }
        }

        String z = "";
        for (int i = x; i < y.length() - 1; i++) {
            z += y.charAt(i);
        }

        String sp[] = z.split(",");
        int arr[]=new int[sp.length+1];
        for (int i = 0; i < sp.length; i++) {
            arr[i]=Integer.parseInt(sp[i]);
        }
        arr[sp.length]=num;
        Arrays.sort(arr);
        String fi="";
        fi+="[";
        for(int i=0;i<sp.length+1;i++){
            fi+=Integer.toString(arr[i]);
            if(i!=sp.length){
                fi+=",";
            }
        }
        fi+="]";
        String war="";
        for(int u=0;u<x-1;u++){
            war+=y.charAt(u);
        }

        return  war+fi;
    }

    //******************************************************************************************************
    //******************************************************************************************************
    void THEEND(ArrayList<LinkedList>alist){
        if(alist.size()==1){
            LinkedList<String> linkedList  = alist.get(0);
            for(int i=0;i<linkedList.size();i++){
                theEndOfWar.push(linkedList.get(i));
            }
        }else if(alist.size()==0){
            return;

        }
        else{
            ArrayList<LinkedList>king=new ArrayList<LinkedList>();
            boolean arr[]=new boolean[alist.get(0).size()];
            boolean arr2[]=new boolean[alist.get(1).size()];
            king.add(TS(alist.get(0),alist.get(1),arr,arr2));
            getprimitiveHighr(arr,alist.get(0));
            if(alist.size()==2){
                getprimitiveHighr(arr2,alist.get(1));
            }
            for(int i=1;i<alist.size()-1;i++){
                arr=arr2;
                arr2=new boolean[alist.get(i+1).size()];
                king.add(TS(alist.get(i),alist.get(i+1),arr,arr2));
                getprimitiveHighr(arr,alist.get(i));
                if(i==alist.size()-2){
                    getprimitiveHighr(arr2,alist.get(i+1));
                }
            }
            trim(king);
            print(king);
            THEEND(king);


        }
    }
    //******************************************************************************************************
    private void print(ArrayList<LinkedList>X){
        for(int i=0;i<X.size();i++){
            if(X.get(i).size()==0){
                String tt="";
                // tt+=done.getText();
                // theWar+=("\n"+"NULL"+"\n");
                //tt+=("\n"+"NULL"+"\n");
                System.out.println("NULL");
            }
            else{
                for(int j=0;j<X.get(i).size();j++){
                    String tt="";
                    // tt+=done.getText();
                    // tt+=(X.get(i).get(j)+"\n");
                    theWar+=(X.get(i).get(j)+"\n");
                    // done.setText(tt);
                    System.out.println(X.get(i).get(j));
                }
            }
            String tt="";
            //tt+=done.getText();
            // tt+=("\n"+"___________________"+"\n");
            // done.setText(tt);
            theWar+=("\n"+"___________________"+"\n");
            System.out.println("**********");
        }
        String tt="";
        //tt+=done.getText();
        // tt+=("\n \n \n \n \n \n \n");
        //done.setText(tt);
        theWar+=("\n \n \n \n \n \n \n");
        System.out.println("\n \n \n ");
    }

    //******************************************************************************************************
    private LinkedList TS (LinkedList <String>a, LinkedList<String>b,boolean arr[],boolean arr2[]){
        LinkedList <String> FINE=new LinkedList<String>();
        for(int i=0;i<a.size();i++){
            for(int j=0;j<b.size();j++){
                String w=a.get(i);
                String p=b.get(j);
                if(sub(a.get(i),b.get(j))&&same(a.get(i),b.get(j))){
                    arr[i]=true;
                    arr2[j]=true;
                    String z=Mix(submum(a.get(i),b.get(j)),a.get(i));
                    if (!FINE.contains(z)) {
                        FINE.add(z);
                    }

                }
            }
        }
        return FINE;
    }
    //******************************************************************************************************
    private int submum(String a,String b){
        String o="";
        String t="";
        for(int i=0;i<a.length();i++){
            o+=a.charAt(i);
            if(a.charAt(i+1)=='[') break;
        }
        for(int i=0;i<b.length();i++){
            t+=b.charAt(i);
            if(b.charAt(i+1)=='[') break;
        }
        int x=Integer.parseInt(o);
        int y=Integer.parseInt(t);
        return y-x;
    }
    //******************************************************************************************************
    private boolean sub(String a,String b){
        String o="";
        String t="";
        for(int i=0;i<a.length();i++){
            o+=a.charAt(i);
            if(a.charAt(i+1)=='[') break;
        }
        for(int i=0;i<b.length();i++){
            t+=b.charAt(i);
            if(b.charAt(i+1)=='[') break;
        }
        int x=Integer.parseInt(o);
        int y=Integer.parseInt(t);
        return multiple(y-x);

    }
}
class ways {

    int num ;
    String deathnums1[];
    String deathLetters1[];
    String deathnums2[];
    String deathLetters2[];

    //******************************************************************************************************
    public Stack justice2(Stack<Integer>war,TextArea finall,String e){
        deathnums1=new String[war.size()];
        deathLetters1=new String[war.size()];
        int countOfDeath=0;

        String t="\n";
        Stack <String> d=new Stack<>();
        char arr[] = new char[num];
        arr[0] = 'A';
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (char) (arr[i - 1] + 1);

        }
        reverse(arr, arr.length);
        while (!war.empty()) {
            int numm=war.peek();
            deathnums1[countOfDeath]=Integer.toString(numm);
            String pain="";
            int count=0;
            while (numm!=0){
                if(numm%2==0){
                    pain+="‘";
                    pain+=arr[count++];
                }else{

                    pain+=arr[count++];
                }
                numm/=2;
            }
            for(int i=count;i<arr.length;i++){
                pain+="‘";
                pain+=arr[i];
            }
            pain=rev(pain);
            t+=pain;
            t+="\n";
            deathLetters1[countOfDeath++]=pain;

            System.out.println(pain);
            d.add(pain);
            war.pop();
        }

        finall.setText(e+""+t);
        return d;
    }
    //******************************************************************************************************
    public Stack<String> justice(Stack<String> war, TextArea finall) {
        deathLetters2=new String[war.size()];
        deathnums2=new String[war.size()];
        int countOfDeath=0;
        Stack <String>d=new Stack<>();
        String t=finall.getText();
        // t+="\n";
        char arr[] = new char[num];
        arr[0] = 'A';
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (char) (arr[i - 1] + 1);

        }
        reverse(arr, arr.length);
        while (!war.empty()) {

            String x = war.peek();
            deathnums2[countOfDeath]=x;
            String y = trns(x);
            String dead = "";
            HashSet <Integer>xx=death(x);
            for (int i=0;i<y.length();i++){
                if(xx.contains(i)){
                    continue;
                }
                if(y.charAt(i)=='1'){
                    dead+=arr[i];
                }else {
                    dead+="‘";
                    dead+=arr[i];
                }
            }
            dead=rev(dead);
            deathLetters2[countOfDeath++]=dead;
            System.out.println(dead);
            d.add(dead);
            t+=dead;
            t+="\n";


            war.pop();
        }
        //String yy=finall.getText();
        finall.setText(""+t);
        deathtotal();
        return d;
    }
    static String sacnum[];
    static   String sacLet[];


    void deathtotal(){
        sacLet=new String[deathLetters2.length+deathLetters1.length];
        sacnum=new String[deathLetters2.length+deathLetters1.length];
        for(int i=0;i<deathLetters1.length;i++){
            sacLet[i]=deathLetters1[i];
            sacnum[i]=deathnums1[i];
        }
        for(int i=deathLetters1.length;i<deathLetters2.length+deathLetters1.length;i++){
            sacLet[i]=deathLetters2[i-deathnums1.length];
            sacnum[i]=deathnums2[i-deathnums1.length];

        }

    }
    //******************************************************************************************************
    private String rev(String x){
        String dead="";
        for(int i=x.length()-1;i>=0;i--){
            dead+=x.charAt(i);
        }
        return  dead;
    }

    //******************************************************************************************************
    private HashSet death(String x){
        int num = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '[') {
                num = i;
                break;
            }
        }
        String ww="";
        for(int i=num+1;i<x.length()-1;i++){
            ww+=x.charAt(i);

        }
        HashSet<Integer>xx=new HashSet<Integer>();
        String u[]=ww.split(",");
        int sacrifice[]=new int[u.length];
        for(int i=0;i<u.length;i++){
            sacrifice[i]=Integer.parseInt(u[i]);
            sacrifice[i]=Math.round(log(sacrifice[i]));
            xx.add(sacrifice[i]);
        }


        return xx;
    }


    //******************************************************************************************************
    private int log(int x){
        int count=0;
        while (x!=0){
            count++;
            x/=2;
        }
        return count-1;
    }

    //******************************************************************************************************
    private void reverse(char[] arr, int length) {
        for (int i = 0; i < length / 2; i++) {
            char x = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = x;
        }

    }
    //******************************************************************************************************
    private String trns(String x) {
        int numm = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '[') {
                numm = i;
                break;
            }
        }
        String w = "";
        for (int i = 0; i < numm; i++) {
            w += x.charAt(i);
        }
        int r = Integer.parseInt(w);
        String fine = "";
        while (r != 0) {
            if (r % 2 == 0) {
                fine += "0";
            } else {
                fine += "1";
            }
            r /= 2;
        }


        while (fine.length()!=num){
            int o=fine.length();
            int p=num;
            fine+="0";
        }
        return fine;
    }



}



class  Essential{

    HashSet h;
    HashSet EssentialPrimeImplicint=new HashSet();
    // Stack<String> NUMS;
    //  Stack<String> Letters;
    TextArea end;
    HashSet complemented=new HashSet();

    int beginNumOfMinTerms;
    Label need;
    TextArea func;
    Essential(  HashSet h,Stack<String> NUMS,Stack<String> Letters,TextArea end,Label need ,TextArea func){
        this.h=h;
        // this.NUMS=NUMS;
        // this.Letters=Letters;
        this.end=end;
        beginNumOfMinTerms=h.size();
        this.need=need;
        this.func=func;
        if(Letters.size()==1&&Letters.peek()==""){
            func.setText("Function is true all times");
            need.setText("");
        }else {
            dead();
        }
    }
    ArrayList <LinkedList> death=new ArrayList<>();
    void dead() {
        int y = ways.sacnum.length;
        for (int i = 0; i < y; i++) {
            LinkedList<Object> temp = new LinkedList<Object>();
            death.add(temp);

            death.get(i).add(ways.sacnum[i]);
            death.get(i).add(ways.sacLet[i]);
        }

        for (int i = 0; i < y; i++) {
            boolean arrExisit[] = new boolean[h.size()];
            die(arrExisit, death.get(i));

        }

        Iterator<Integer> w = h.iterator();
        String add="";
        int o=0;
        for (int i = 0; i < h.size(); i++) {
            o=w.next();
            //System.out.print(o + "               ");
            add+=(o+"            ");
        }
        add+="\n \n";
        System.out.println("\n\n ");
        for (int j = 0; j < death.size(); j++) {
            w = h.iterator();
            LinkedList <?>t =death.get(j);

            for (int i = 2; i < t.size(); i++) {
               // System.out.print(t.get(i) + "  ");
                add+=(t.get(i) + "        ");
            }
            add+=t.get(0);
            add+="  ";
            add+=t.get(1);
            add+=("\n\n");
            System.out.println("\n\n ");
        }
        String u=end.getText();
        u+="\n\n";
        u+=add;
        end.setText(u);

        TheEndOfWar();

    }

    void TheEndOfWar(){


        getEssential();


        if(h.size()==0||death.size()==0) {
            Iterator<String> w = EssentialPrimeImplicint.iterator();
            String doo="";
            for(int ttt=0;ttt<EssentialPrimeImplicint.size();ttt++){
                doo+=w.next();
                if(ttt!=EssentialPrimeImplicint.size()-1)
                    doo+=" + ";
            }
            w = EssentialPrimeImplicint.iterator();
            int pof=0;
            int cost=0;
            for(int r=0;r<EssentialPrimeImplicint.size();r++){
                String e=w.next();
                cost+=e.length()+1;
                int com=0;
                int siz=0;
                for(int ww=0;ww<e.length();ww++){
                    if(e.charAt(ww)=='‘'){
                        com++;
                    }else{
                        siz++;
                    }
                }
                if(siz==1)
                    cost--;
                cost-=com;
            }//+"\n Cost : \"+min+\" U.C\"");
            cost+=complemented.size();
            if(EssentialPrimeImplicint.size()==1)
                cost--;
             func.setText(doo);
             need.setText(" Cost : " +(cost) +" U.C");
            return;
        }

        boolean flag1= rowDominane();
        boolean flag2= columDominate();
        if(flag1||flag2){
            TheEndOfWar();
            return;

        }
        patric();


    }

    int getFinalCost(HashSet s){
        Iterator<String>  w =s.iterator();
        int cost=0;
        HashSet oo=new HashSet();
        for(int i=0;i<s.size();i++){
            String t=w.next();
            cost+=t.length()+1;
            int siz=0;
            for(int j=0;j<t.length();j++){
                if(t.charAt(j)=='‘'){
                    cost--;
                    if(!oo.contains(t.charAt(j-1))){
                        oo.add(t.charAt(j-1));
                    }
                }else{
                    siz++;
                }
            }
            if(siz==1)
                cost--;
        }
        cost+=oo.size();
        if(s.size()==1)
            return cost-1;
        return cost;
    }

    void patric(){
        char arr[] = new char[death.size()];
        arr[0] = 'A';
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (char) (arr[i - 1] + 1);

        }

        ArrayList  <LinkedList> x =new ArrayList<>();

        for(int i=0;i<h.size();i++){
            x.add(new LinkedList());
            for(int j=0;j<death.size();j++){
                if((boolean)death.get(j).get(i+2)==true){
                    x.get(i).add(arr[j]);

                }
            }
        }
        int numOfTotal=1;
        for(int i=0;i<h.size();i++){
            numOfTotal*=x.get(i).size();
        }
        String arrDeath[]=new String[numOfTotal];

        int point[]=new int[h.size()];
        for(int i=0;i<h.size();i++){
            point[i]=0;
        }
        for(int yy=0;yy<numOfTotal;yy++){
            arrDeath[yy]="";
        }
        extendPatric(x,point,arrDeath,0,numOfTotal);


        int costFake[]=new int[arrDeath.length];
        for (int i=0;i<arrDeath.length;i++){
            costFake[i]= getFakeCost(arrDeath[i]);
        }

        int min=1000000000;
        for(int i=0;i<costFake.length;i++){
            if(costFake[i]<min){
                min=costFake[i];
            }
        }
        int nums=0;
        for(int i=0;i<costFake.length;i++){
            if(costFake[i]==min){
                nums++;
            }
        }
        String oo[]=new String[nums];
        int hh=0;
        for(int i=0;i<costFake.length;i++){
            if(costFake[i]==min){
                oo[hh++]=arrDeath[i];
            }
        }

        char arr2[] = new char[death.size()];
        arr2[0] = 'A';
        for (int i2 = 1; i2 < arr2.length; i2++) {
            arr2[i2] = (char) (arr2[i2 - 1] + 1);

        }
        int nn[]=new int[death.size()];
        for(int r=0;r<death.size();r++){
            nn[r]=r;
        }
        String yy="";
        HashSet ahmedAlzayady=new HashSet();
        boolean ff=false;

        for(int die=0;die<oo.length;die++){
            Iterator<String> w = EssentialPrimeImplicint.iterator();
            for(int t=0;t<EssentialPrimeImplicint.size();t++){
                String qwe=w.next();
                yy+=qwe;
                ahmedAlzayady.add(qwe);
                yy+= " + ";
            }
            String sec=oo[die];
            for(int y=0;y<sec.length();y++){
                for(int q=0;q<death.size();q++){
                    if(arr2[q]==sec.charAt(y)){
                        yy+=death.get(q).get(1);
                        if(!ff)
                            ahmedAlzayady.add(death.get(q).get(1));


                    }

                }

                if(y!=sec.length()-1){
                    yy+=" + ";
                }
            }
            ff=true;
            if(die!=oo.length-1){
                yy+="\n or \n ";
            }
        }
        String y="";
        y+=" \n Cost : "+getFinalCost(ahmedAlzayady)+" U.C";
        need.setText(y);
        func.setText(yy);


    }
  /* HashSet Store(String [] oo){
      HashSet oop=new HashSet();
      for(int i=0;i<oo.length;i++){
          for(int j=0;j<oo[i].length();j++){
              for(int k=0;k<oo[i].length()-j-1;k++){
                  if(oo[i].charAt(j)>oo[i].charAt(j+1)){
                      //char temp=oo[i].charAt(j);
                      SWAP(oo[i].charAt(j),oo[i].charAt(j+1));

                  }
              }
          }
      }
    }*/

    int getFakeCost(String doo){
        char arr[] = new char[death.size()];
        arr[0] = 'A';
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (char) (arr[i - 1] + 1);

        }

        int numsOfElement[]=new int[doo.length()];
        for(int i=0;i<numsOfElement.length;i++){
            numsOfElement[i]=getNum(doo.charAt(i),arr);
        }

        int totalFakeCost=0;
        HashSet fakeComplemented=new HashSet();
        for(int i=0;i<numsOfElement.length;i++){
            String y=(String) death.get(numsOfElement[i]).get(1);
            totalFakeCost+=getCost(y);
            for(int j=0;j<y.length();j++){
                if(y.charAt(j)=='‘'){
                    if(!complemented.contains(y.charAt(j-1))){
                        if(fakeComplemented.contains(y.charAt(j-1))){
                            totalFakeCost--;
                        }else {
                            fakeComplemented.add(y.charAt(j-1));
                        }
                    }
                }
            }

        }
        return totalFakeCost;


    }

    int getNum(char c,char arr[]){

        int num=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==c){
                num=i;
                break;
            }
        }
        return num;
    }





    void extendPatric(ArrayList <LinkedList>x, int point[],String arr[], int tour,int numOfTotal){

        for(int u=0;u<numOfTotal;u++) {
            for (int i = 0; i < h.size(); i++) {
                boolean flag = true;
                for (int j = 0; j < arr[tour].length(); j++) {
                    if (arr[tour].charAt(j) == (Character) x.get(i).get(point[i])) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    arr[tour] += x.get(i).get(point[i]);
            }

            if (arr[arr.length - 1] != "") {
                return;
            }
            plusPatric(x, point, 0);
            //System.out.println("tour is" + tour);
            //  extendPatric(x, point, arr, tour + 1, numOfTotal);
            tour++;
        }
    }
    void plusPatric(ArrayList <LinkedList> x, int point[], int tour){
        // System.out.println("point is" +  (point.length-1-tour) + "at tour "+(tour));

        if(point[point.length-1-tour]!=x.get(point.length-1-tour).size()-1){
            point[point.length-1-tour]++;
            String g="";


            return;
        }
        //  System.out.println("tour is"+tour );
        plusPatric(x,point,tour+1);
        point[point.length-1-tour]=0;
    }

    boolean columDominate(){

        boolean flag=false;
        for(int i=2;i<death.get(0).size();i++){
            for(int j=i+1;j<death.get(0).size();j++){
                if(winner(i,j)){
                    remove(j);
                    flag=true;
                }else if(winner(j,i)){
                    remove(i);
                    flag=true;
                }
            }
        }
        return flag;
    }
    void remove(int num){

        Iterator<Integer> w = h.iterator();
        for(int e=0;e<num-2;e++){
            w.next();
        }
        int www=w.next();
        h.remove(www);

        for(int i=0;i<death.size();i++){
            death.get(i).remove(num);
        }

    }

    boolean winner(int one, int two){
        for(int i=0;i<death.size();i++){
            if((boolean)death.get(i).get(one)==true){
                if((boolean)death.get(i).get(two)==false){
                    return false;
                }
            }
        }
        return  true;
    }

    boolean rowDominane(){
        boolean f=false;
        for(int i=0;i<death.size();i++){
            for(int j=i+1;j<death.size();j++){
                if(vaidateRow(death.get(i),death.get(j))){
                    death.remove(j);
                    i=0;j=0;

                    f=true;
                }else if (vaidateRow(death.get(j),death.get(i))){
                    death.remove(i);
                    f=true;
                    i=0;
                    j=0;
                }
            }
        }
        return f;
    }

    boolean vaidateRow(LinkedList one,LinkedList two){


        if(getCost((String) two.get(1))>getCost((String) one.get(1))){

            for(int i=2;i<one.size();i++){
                if((boolean)two.get(i)==true)
                {
                    if((boolean)one.get(i)==false){
                        return false;
                    }
                }
            }
        }else {
            return false;
        }
        return true;
    }


    int getCost(String lett){

        int cost=0;
        cost=lett.length()+1;
        for(int i=0;i<lett.length()-1;i++){
            if(lett.charAt(i)!='‘'){
                if(lett.charAt(i+1)=='‘'){
                    if(complemented.contains(lett.charAt(i))){
                        cost--;
                    }


                }
            }

        }
        return cost;
    }

    void getEssential(){
        for(int i=2;i<death.get(0).size();i++) {
            int count = 0;
            int here = 0;
            for (int j = 0; j < death.size(); j++) {
                if ((boolean) death.get(j).get(i) == true) {
                    count++;
                    here = j;
                }
            }
            if (count == 1) {

                for (int c = 2; c < death.get(0).size(); c++) {

                    if ((boolean) death.get(here).get(c) == true) {
                        Iterator<Integer> w = h.iterator();
                        for (int e = 0; e < c - 2; e++) {
                            w.next();
                        }
                        int www = w.next();
                        h.remove(www);

                        for (int k = 0; k < death.size(); k++) {
                            death.get(k).remove(c);
                        }
                        c--;


                    }

                }

                EssentialPrimeImplicint.add(death.get(here).get(1));
                for (int r = 0; r < ((String) death.get(here).get(1)).length(); r++) {
                    if (((String) death.get(here).get(1)).charAt(r) == '‘') {
                        if (!complemented.contains(((String) death.get(here).get(1)).charAt(r - 1))) {


                            complemented.add(((String) death.get(here).get(1)).charAt(r - 1));
                        }
                    }
                }
                System.out.println(death.get(here).get(1));
                death.remove(here);
                i = 1;

            }
            if (death.size() == 0)
                break;


        }
        System.out.println(EssentialPrimeImplicint);


    }




    void die(boolean arr[],LinkedList<Object> t) {

        HashSet last = did((String) t.get(0));
        Iterator<Integer> w = h.iterator();

        for (int i = 0; i < h.size(); i++) {
            if (last.contains(w.next())) {
                t.add(true);
            } else {
                t.add(false);
            }

        }
    }


    HashSet did(String x){
        int numm=0;
        String war="";
        String fine="";
        for(int i =0;i<x.length();i++){
            if(!Character.isDigit(x.charAt(i))){
                numm=i;
                for(int j=0;j<i;j++){
                    war+=x.charAt(j);
                }
                for(int j=i+1;j<x.length()-1;j++){
                    fine+=x.charAt(j);
                }

                break;
            }
            else if(i==x.length()-1){
                HashSet <Integer>t=new HashSet< Integer>();
                t.add(Integer.parseInt(x));
                return  t;
            }

        }

        String r[]=fine.split(",");

        int baseNum=Integer.parseInt(war);

        HashSet <Integer>t=new HashSet<>();
        int elements[]=new int [r.length];
        for(int i=0;i<r.length;i++){
            elements[i]=Integer.parseInt(r[i]);
        }

        t.add(baseNum);
        for(int i =1;i<=r.length;i++){
            int arrbegin[]=new int[i];
            int arrarrive[]=new int[i];
            for(int j=0;j<i;j++){
                arrbegin[j]=j;
                arrarrive[j]=r.length-i+j;
            }
            HashSet container =new HashSet();
            HashSet temp= TheEndOFWorld( baseNum,elements, arrbegin, arrarrive, i,container);
            Iterator <Integer> w=temp.iterator();
            for(int i2=0;i2<temp.size();i2++){
                t.add(w.next());
            }

        }
        return t;



    }
    HashSet TheEndOFWorld( int baseElement,int []elemrnts,int arrbegin[],int arrarrive[],int numOfSums,HashSet continer){


        int end=baseElement;
        for(int i=0;i<arrbegin.length;i++){
            end+=elemrnts[arrbegin[i]];
        }

        continer.add(end);
        for(int i=0;i<numOfSums;i++){
            if(arrarrive[i]!=arrbegin[i]){
                break;
            }
            else if(i==numOfSums-1){
                return continer;
            }
        }

        plus(arrbegin,arrarrive,0);
        return TheEndOFWorld(  baseElement,elemrnts, arrbegin, arrarrive, numOfSums, continer);



    }

    private void plus(int arrbegin[],int arrarrive[],int tour){
        if(arrbegin[arrbegin.length-1-tour]!=arrarrive[arrbegin.length-1-tour]){
            arrbegin[arrbegin.length-1-tour]++;
            return;
        }
        plus(arrbegin,arrarrive,tour+1);
        arrbegin[arrarrive.length-1-tour]=arrbegin[arrarrive.length-2-tour]+1;
    }
}