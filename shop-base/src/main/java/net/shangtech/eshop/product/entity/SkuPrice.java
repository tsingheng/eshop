package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.orm.dao.support.BaseEntity;

@Entity
@Table(name = "t_sku_price")
public class SkuPrice extends BaseEntity<Long> {

    private static final long serialVersionUID = 4481445109437240657L;

    @Column(name = "sku_id")
    @Index(name = "idx_sku_price_sku_id")
    private Long skuId;
    
    @Column(name = "min")
    private Integer min;
    
    @Column(name = "max")
    private Integer max;
    
    @Column(name = "price")
    private Double price;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
    
}
