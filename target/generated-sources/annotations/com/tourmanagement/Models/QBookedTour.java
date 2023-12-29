package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookedTour is a Querydsl query type for BookedTour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookedTour extends EntityPathBase<BookedTour> {

    private static final long serialVersionUID = -66251266L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookedTour bookedTour = new QBookedTour("bookedTour");

    public final DateTimePath<java.util.Date> bookingDate = createDateTime("bookingDate", java.util.Date.class);

    public final QCustomer customer;

    public final QDiscount discount;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isPaid = createBoolean("isPaid");

    public final StringPath note = createString("note");

    public final EnumPath<com.tourmanagement.Shared.Types.EnumStatusBookedTour> status = createEnum("status", com.tourmanagement.Shared.Types.EnumStatusBookedTour.class);

    public final NumberPath<Double> totalMoney = createNumber("totalMoney", Double.class);

    public final QTour tour;

    public QBookedTour(String variable) {
        this(BookedTour.class, forVariable(variable), INITS);
    }

    public QBookedTour(Path<? extends BookedTour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookedTour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookedTour(PathMetadata metadata, PathInits inits) {
        this(BookedTour.class, metadata, inits);
    }

    public QBookedTour(Class<? extends BookedTour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer")) : null;
        this.discount = inits.isInitialized("discount") ? new QDiscount(forProperty("discount"), inits.get("discount")) : null;
        this.tour = inits.isInitialized("tour") ? new QTour(forProperty("tour"), inits.get("tour")) : null;
    }

}

