package tv.codely.mooc.videos.application.create;

import org.springframework.stereotype.Service;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.videos.domain.VideoRepositoryInterface;

@Service
public class VideoCreator{

	private final VideoRepositoryInterface repository;

	public VideoCreator(VideoRepositoryInterface repository) {
		this.repository = repository;
	}


	public VideoStep createVideo(String id, String title, String url, String text) {
		return repository.createVideo(id, title, url, text);
	}
}
