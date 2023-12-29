package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSightseeingSpot is a Querydsl query type for SightseeingSpot
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSightseeingSpot extends EntityPathBase<SightseeingSpot> {

    private static final long serialVersionUID = -2078172624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSightseeingSpot sightseeingSpot = new QSightseeingSpot("sightseeingSpot");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QProvince province;

    public QSightseeingSpot(String variable) {
        this(SightseeingSpot.class, forVariable(variable), INITS);
    }

    public QSightseeingSpot(Path<? extends SightseeingSpot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSightseeingSpot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSightseeingSpot(PathMetadata metadata, PathInits inits) {
        this(SightseeingSpot.class, metadata, inits);
    }

    public QSightseeingSpot(Class<? extends SightseeingSpot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.province = inits.isInitialized("province") ? new QProvince(forProperty("province")) : null;
    }

}

