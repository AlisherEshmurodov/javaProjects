package com.copyProjects.pdp.onlineFastFood_evos.com.services.imples;

public class Test {

    static Test test;

    public static Test getInstance() {
        if(test==null){
            test = new Test();
        }
        return test;
    }

    public void test() {

    }
}
