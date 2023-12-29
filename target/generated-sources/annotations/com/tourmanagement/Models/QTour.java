package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTour is a Querydsl query type for Tour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTour extends EntityPathBase<Tour> {

    private static final long serialVersionUID = -2140251370L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTour tour = new QTour("tour");

    public final NumberPath<Integer> availableSeats = createNumber("availableSeats", Integer.class);

    public final DateTimePath<java.util.Date> departureDate = createDateTime("departureDate", java.util.Date.class);

    public final StringPath departureLocation = createString("departureLocation");

    public final StringPath destinationLocation = createString("destinationLocation");

    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath gatheringAddress = createString("gatheringAddress");

    public final QTourGuide guide;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idSightSeeing = createString("idSightSeeing");

    public final StringPath images = createString("images");

    public final NumberPath<Integer> likes = createNumber("likes", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final NumberPath<Double> rating = createNumber("rating", Double.class);

    public final NumberPath<Integer> registeredSeats = createNumber("registeredSeats", Integer.class);

    public final EnumPath<com.tourmanagement.Shared.Types.EnumStatusTour> status = createEnum("status", com.tourmanagement.Shared.Types.EnumStatusTour.class);

    public final EnumPath<com.tourmanagement.Shared.Types.EnumTransportModeTour> transportationMode = createEnum("transportationMode", com.tourmanagement.Shared.Types.EnumTransportModeTour.class);

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QTour(String variable) {
        this(Tour.class, forVariable(variable), INITS);
    }

    public QTour(Path<? extends Tour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTour(PathMetadata metadata, PathInits inits) {
        this(Tour.class, metadata, inits);
    }

    public QTour(Class<? extends Tour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.guide = inits.isInitialized("guide") ? new QTourGuide(forProperty("guide")) : null;
    }

}

