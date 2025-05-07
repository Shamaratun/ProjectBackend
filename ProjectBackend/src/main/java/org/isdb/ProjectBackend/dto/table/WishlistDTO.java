package org.isdb.ProjectBackend.dto.table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDTO {
	private Integer wishlistID;
	private Integer userID; // Only include ID to avoid circular references
	private List<WishlistItemDTO> items;
}
