package com.tourmanagement.Models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = -245964388L;

    public static final QCustomer customer = new QCustomer("customer");

    public final StringPath address = createString("address");

    public final StringPath avatar = createString("avatar");

    public final ListPath<BookedTour, QBookedTour> bookedTours = this.<BookedTour, QBookedTour>createList("bookedTours", BookedTour.class, QBookedTour.class, PathInits.DIRECT2);

    public final ListPath<CustomerDiscount, QCustomerDiscount> customerDiscounts = this.<CustomerDiscount, QCustomerDiscount>createList("customerDiscounts", CustomerDiscount.class, QCustomerDiscount.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    public final StringPath email = createString("email");

    public final BooleanPath gender = createBoolean("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idCard = createString("idCard");

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

