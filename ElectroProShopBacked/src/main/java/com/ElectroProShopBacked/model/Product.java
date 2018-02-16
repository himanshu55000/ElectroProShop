package com.ElectroProShopBacked.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int proId;
	@NotEmpty(message="Can't Be blank")
	@Size(max = 50, min = 3, message = "Name should be between 3 to 50 characters")
	private String proName; 
	@NotNull(message="Can't Be blank")
	private String proDesc;
	@NotNull(message="Can't Be blank")
	private int proQuantity;
	@NotNull(message="Can't Be blank")
	private Float proPrice;
	@NotNull(message="Choose One")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sid")
	private Supplier supplier;
	@NotNull(message="Choose One")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private Category category;
	
	@Transient
	@NotNull(message="Choose a Image")
	private MultipartFile proImage;
	
	private String imageName;
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public int getProQuantity() {
		return proQuantity;
	}

	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}

	public Float getProPrice() {
		return proPrice;
	}

	public void setProPrice(Float proPrice) {
		this.proPrice = proPrice;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MultipartFile getProImage() {
		return proImage;
	}

	public void setProImage(MultipartFile proImage) {
		this.proImage = proImage;
	}

}
