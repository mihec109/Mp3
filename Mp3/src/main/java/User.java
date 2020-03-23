/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mihah
 */
class User {
    public static int user_id;
    private int id;
    private String firstname;
    private String lastname;
    private String mail;
    
        public User(int _id, String _firstname, String _lastname, String _mail){
        id = _id;
        firstname = _firstname;
        lastname = _lastname;
        mail = _mail;
    }
}
