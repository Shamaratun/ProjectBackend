package org.isdb.ProjectBackend.dto.table;

import org.isdb.ProjectBackend.model.WishlistItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItemDTO {

	private Integer wishlistItemID;
	private Integer wishlistID;
	private Integer bookID;
	

}
