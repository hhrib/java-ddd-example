package tv.codely.mooc.videos.infrastructure;


import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.steps.domain.video.VideoStepText;
import tv.codely.mooc.videos.domain.VideoRepositoryInterface;
import tv.codely.shared.domain.VideoUrl;

public class VideoInMemRepository implements VideoRepositoryInterface {

	@Override
	public VideoStep createVideo(String id, String title, String url, String text) {
		StepId stepId = new StepId(id);
		StepTitle stepTitle = new StepTitle(title);
		VideoUrl videoUrl = new VideoUrl(url);
		VideoStepText videoStep = new VideoStepText(text);
		return new VideoStep(stepId, stepTitle, videoUrl, videoStep);
	}
}
