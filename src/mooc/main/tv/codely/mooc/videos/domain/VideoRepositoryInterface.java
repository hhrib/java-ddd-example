package tv.codely.mooc.videos.domain;

import tv.codely.mooc.steps.domain.video.VideoStep;

public interface VideoRepositoryInterface {
	public VideoStep createVideo(String id, String title, String url, String text);
}
