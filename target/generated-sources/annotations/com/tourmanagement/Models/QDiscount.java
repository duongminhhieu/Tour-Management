package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiscount is a Querydsl query type for Discount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiscount extends EntityPathBase<Discount> {

    private static final long serialVersionUID = -578955521L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiscount discount = new QDiscount("discount");

    public final StringPath code = createString("code");

    public final NumberPath<Double> discountPercentage = createNumber("discountPercentage", Double.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> quantityDiscounts = createNumber("quantityDiscounts", Integer.class);

    public final NumberPath<Integer> quantityUsedDiscounts = createNumber("quantityUsedDiscounts", Integer.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final EnumPath<com.tourmanagement.Shared.Types.EnumStatusDiscount> status = createEnum("status", com.tourmanagement.Shared.Types.EnumStatusDiscount.class);

    public final QTour tour;

    public QDiscount(String variable) {
        this(Discount.class, forVariable(variable), INITS);
    }

    public QDiscount(Path<? extends Discount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiscount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiscount(PathMetadata metadata, PathInits inits) {
        this(Discount.class, metadata, inits);
    }

    public QDiscount(Class<? extends Discount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tour = inits.isInitialized("tour") ? new QTour(forProperty("tour"), inits.get("tour")) : null;
    }

}

