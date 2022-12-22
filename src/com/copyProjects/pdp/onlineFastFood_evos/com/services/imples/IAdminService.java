package com.copyProjects.pdp.onlineFastFood_evos.com.services.imples;

import com.copyProjects.pdp.onlineFastFood_evos.com.Storage;
import com.copyProjects.pdp.onlineFastFood_evos.com.services.interfacess.AdminService;

public class IAdminService implements AdminService {

    private static AdminService adminService;

    public static AdminService getInstance(){
        if (adminService == null){
            adminService = new IAdminService();
        }
        return adminService;
    }

    @Override
    public void adminConsole() {
        System.out.println("Admin Console");
        System.out.println(Storage.users + "  ");
    }
}
