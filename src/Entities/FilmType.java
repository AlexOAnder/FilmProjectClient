package Entities;

import java.io.Serializable;

/**Created by AlexOAnder 
 * 02.01.2016**/

public enum FilmType implements Serializable{
	None (0),
	Comedy (1),
	Action (2),
	Drama (3);
	
	public int Id;
	
	FilmType(int i)
	{
		this.Id = i;
	}

	public int getId() {
        return Id;
    }
	
	public static FilmType fromInt(int i) {
        for (FilmType b : FilmType.values()) {
            if (b.getId() == i) { return b; }
        }
        return null;
    }

}
