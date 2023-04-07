package org.nulljump.dionysos.review.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.review.model.dao.ReviewDao;
import org.nulljump.dionysos.review.model.vo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewDao reviewDao;

	@Override
	public ArrayList<Review> selectReviewList(Paging page) {
		return reviewDao.selectReviewList(page);
	}

	@Override
	public Review selectReview(int review_id) {
		return reviewDao.selectReview(review_id);
	}

	@Override
	public int insertReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public int deleteReview(Review review) {
		return reviewDao.deleteReview(review);
	}

	@Override
	public int getListCount() {
		return reviewDao.getListCount();
	}

	@Override
	public int updateReviewReadcount(int review_id) {
	return reviewDao.updateReviewReadcount(review_id);
	}


}
