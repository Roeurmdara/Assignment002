package co.istad.assigment003.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private Integer id;
    private Integer code;
    private String name;
    private String description;
    private Integer price;
}