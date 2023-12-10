package com.example.final_project;

import java.io.File;
import java.io.FileNotFoundException;

abstract class function_work {

    abstract String function(String tuser);

    abstract void rset_items() throws FileNotFoundException;

    abstract void view_history1() throws FileNotFoundException;


}
