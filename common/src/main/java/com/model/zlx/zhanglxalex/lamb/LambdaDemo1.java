package com.model.zlx.zhanglxalex.lamb;

/**
 * @ClassName LambdaDemo1
 * @Author zhang_lx
 * @Date 2020-08-06 17:02
 * @Version 1.0
 */
public class LambdaDemo1 {

    interface Printer {
        void printer(String val);
    }

    public void printSoming(String somothing, Printer printer) {
        printer.printer(somothing);
    }

    public static void main(String[] args) {

        LambdaDemo1 lambdaDemo1 = new LambdaDemo1();

        /*Printer printer = new Printer() {
            @Override
            public void printer(String val) {
                System.out.println(val);
            }
        };*/

        //简化为lambda
        /*Printer printer = (String val) -> {
            System.out.println(val);
        };*/

        //再简化，去函数类型
        /*Printer printer = (val) -> {
            System.out.println(val);
        };*/

        //再简化，去括号，前提是只有一个参数
        /*Printer printer = val -> {
            System.out.println(val);
        };*/

        //再简化，去大括号，前提是函数体只有一行代码
        //Printer printer = val -> System.out.println(val);

        //lambdaDemo1.printSoming("zlx测试Lambda", printer);

        //最终简化为一行代码
        lambdaDemo1.printSoming("zlx测试Lambda", val -> System.out.println(val));

        //如果不含参数，则按如下写
        //() -> System.out.println("11111");
    }

}
