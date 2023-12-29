package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTourGuide is a Querydsl query type for TourGuide
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTourGuide extends EntityPathBase<TourGuide> {

    private static final long serialVersionUID = 117206406L;

    public static final QTourGuide tourGuide = new QTourGuide("tourGuide");

    public final StringPath address = createString("address");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idCard = createString("idCard");

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<Tour, QTour> tours = this.<Tour, QTour>createList("tours", Tour.class, QTour.class, PathInits.DIRECT2);

    public QTourGuide(String variable) {
        super(TourGuide.class, forVariable(variable));
    }

    public QTourGuide(Path<? extends TourGuide> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTourGuide(PathMetadata metadata) {
        super(TourGuide.class, metadata);
    }

}

