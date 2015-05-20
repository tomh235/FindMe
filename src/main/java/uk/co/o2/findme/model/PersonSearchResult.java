package uk.co.o2.findme.model;

public class PersonSearchResult {
    public String name;
    public String teamName;
    public String picture;
    public String email;
    public String role;
    public String colour;
    public String link;

    public PersonSearchResult(String name, String teamName, String picture, String email, String role, String colour, String link) {
        this.name = name;
        this.teamName = teamName;
        this.picture = picture;
        this.email = email;
        this.role = role;
        this.colour = colour;
        this.link = link;
    }
}
