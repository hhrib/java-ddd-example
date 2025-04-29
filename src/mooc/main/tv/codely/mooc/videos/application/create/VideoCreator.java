package tv.codely.mooc.videos.application.create;

import org.springframework.stereotype.Service;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.steps.domain.video.VideoStepText;
import tv.codely.shared.domain.VideoUrl;

@Service
public class VideoCreator {

	public VideoStep createVideo(String id, String title, String url, String text) {
		StepId stepId = new StepId(id);
		StepTitle stepTitle = new StepTitle(title);
		VideoUrl videoUrl = new VideoUrl(url);
		VideoStepText videoStep = new VideoStepText(text);
		return new VideoStep(stepId, stepTitle, videoUrl, videoStep);

	}
}
