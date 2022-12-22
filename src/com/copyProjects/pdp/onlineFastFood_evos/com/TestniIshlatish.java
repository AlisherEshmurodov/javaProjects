package com.copyProjects.pdp.onlineFastFood_evos.com;

import com.copyProjects.pdp.onlineFastFood_evos.com.services.imples.Test;

public class TestniIshlatish {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();

        Test test1 = Test.getInstance();
        test1.test();
    }

    static void testnitekshir(){
        Test test = new Test();
        test.test();

        Test test1 = Test.getInstance();
        test1.test();
    }

}
