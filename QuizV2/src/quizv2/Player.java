/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizv2;



/**
 *
 * @author Admin
 */
public final class Player {
    
    private int id;
    private String prenom;
    private String nom;
    private int age;

    private static int compteur = 1;

    public Player() {
    }

    public Player(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        setId(compteur++);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Player.compteur = compteur;
    }



    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + '}';
    }

    
}
