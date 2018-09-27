package cn.gson.bookmanage.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="b_theme")
public class Theme {

	@Id
	@GeneratedValue(generator="theme",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqtheme", allocationSize = 1, initialValue = 1, name = "theme")
	@Column(name="theme_id")
	private Long themeId;
	
	private String fontfamily;
	
	private Integer isuse;

	
	
	public Long getThemeId() {
		return themeId;
	}

	public void setThemeId(Long themeId) {
		this.themeId = themeId;
	}

	public String getFontfamily() {
		return fontfamily;
	}

	public void setFontfamily(String fontfamily) {
		this.fontfamily = fontfamily;
	}

	public Integer getIsuse() {
		return isuse;
	}

	public void setIsuse(Integer isuse) {
		this.isuse = isuse;
	}

	

	@Override
	public String toString() {
		return "Theme [themeId=" + themeId + ", fontfamily=" + fontfamily + ", isuse=" + isuse + "]";
	}

	public Theme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
