
package edu.webclient.demowebclient.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;

@Getter
@Setter
@ToString
@Generated("jsonschema2pojo")
public class Flavor {

    @SerializedName("flavor")
    @Expose
    public Flavor__1 flavor;
    @SerializedName("potency")
    @Expose
    public Integer potency;

}
