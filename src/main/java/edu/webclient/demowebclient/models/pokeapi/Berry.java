
package edu.webclient.demowebclient.models.pokeapi;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Berry {


    public Firmness firmness;

    public List<Flavor> flavors = null;

    public Integer growthTime;

    public Integer id;

    public Item item;

    public Integer maxHarvest;

    public String name;

    public Integer naturalGiftPower;

    public NaturalGiftType naturalGiftType;

    public Integer size;

    public Integer smoothness;

    public Integer soilDryness;

}
