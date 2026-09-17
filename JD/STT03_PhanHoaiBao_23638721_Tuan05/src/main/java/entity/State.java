package entity;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class State {
    private String StateName;
    private String Abbreviation;
    private String Capital;
    private int Statehood;

    private int ID;
}
