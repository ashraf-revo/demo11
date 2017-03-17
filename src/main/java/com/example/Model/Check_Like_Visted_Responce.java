package com.example.Model;

/**
 * Created by Ashraf Atef on 7/7/2016.
 */
public class Check_Like_Visted_Responce {
    public boolean isVisited_flag() {
        return visited_flag;
    }

    public void setVisited_flag(boolean visited_flag) {
        this.visited_flag = visited_flag;
    }

    public boolean isLiked_flag() {
        return liked_flag;
    }

    public void setLiked_flag(boolean liked_flag) {
        this.liked_flag = liked_flag;
    }

    boolean visited_flag ;
    boolean liked_flag ;
}
