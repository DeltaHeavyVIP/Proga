package dragon;

import person.Person;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Dragon {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private Long age;
    private Color color;
    private DragonType type;
    private DragonCharacter character;
    private Person killer;

    public Dragon (String name,Coordinates coordinates,Long age,Color color,DragonType type,DragonCharacter character,Person killer) throws IllegalArgumentException, NullPointerException {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        if (age == null || age <= 0){
            throw new IllegalArgumentException("Invalid age");
        }
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.killer = killer;
        this.id = Math.toIntExact((UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE));
    }


    public Integer getId(){
        return id;
    }

    public String getName(){ return name; }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public long getAge(){
        return age;
    }

    public Color getColor(){
        return color;
    }

    public DragonType getType(){
        return type;
    }

    public DragonCharacter getCharacter(){
        return character;
    }

    public Person getKiller(){
        return killer;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(Long age){this.age=age;}

    public void setCharacter(DragonCharacter character){ this.character = character;}
    @Override
    public String toString(){
        return this.name;
    }
}