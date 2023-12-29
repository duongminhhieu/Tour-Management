package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerDiscount is a Querydsl query type for CustomerDiscount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerDiscount extends EntityPathBase<CustomerDiscount> {

    private static final long serialVersionUID = -826515715L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerDiscount customerDiscount = new QCustomerDiscount("customerDiscount");

    public final QCustomer customer;

    public final QDiscount discount;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QTour tour;

    public final DateTimePath<java.util.Date> usageDate = createDateTime("usageDate", java.util.Date.class);

    public QCustomerDiscount(String variable) {
        this(CustomerDiscount.class, forVariable(variable), INITS);
    }

    public QCustomerDiscount(Path<? extends CustomerDiscount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerDiscount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerDiscount(PathMetadata metadata, PathInits inits) {
        this(CustomerDiscount.class, metadata, inits);
    }

    public QCustomerDiscount(Class<? extends CustomerDiscount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer")) : null;
        this.discount = inits.isInitialized("discount") ? new QDiscount(forProperty("discount"), inits.get("discount")) : null;
        this.tour = inits.isInitialized("tour") ? new QTour(forProperty("tour"), inits.get("tour")) : null;
    }

}

