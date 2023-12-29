package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScheduleTour is a Querydsl query type for ScheduleTour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScheduleTour extends EntityPathBase<ScheduleTour> {

    private static final long serialVersionUID = -782786483L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScheduleTour scheduleTour = new QScheduleTour("scheduleTour");

    public final NumberPath<Integer> day = createNumber("day", Integer.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final QTour tour;

    public QScheduleTour(String variable) {
        this(ScheduleTour.class, forVariable(variable), INITS);
    }

    public QScheduleTour(Path<? extends ScheduleTour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScheduleTour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScheduleTour(PathMetadata metadata, PathInits inits) {
        this(ScheduleTour.class, metadata, inits);
    }

    public QScheduleTour(Class<? extends ScheduleTour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tour = inits.isInitialized("tour") ? new QTour(forProperty("tour"), inits.get("tour")) : null;
    }

}

