package tv.codely.apps.mooc.backend.controller.videos;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.videos.application.create.VideoCreator;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

@RestController
public class VideosPutController extends ApiController {

	@Autowired
	private VideoCreator videoCreator;

	public VideosPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<>();
	}

	@PutMapping(value = "/videos/{id}")
	public ResponseEntity<VideoStep> createVideo(@PathVariable String id, @RequestBody Request request) {
		System.out.println("Video Creado");
		//		dispatch(new CreateCourseCommand(id, request.name(), request.duration()));
		VideoStep videoStep = videoCreator.createVideo(id, request.getTitle(), request.getUrl(), request.getText());
//		return ResponseEntity.ok(videoStep);
		return new ResponseEntity<VideoStep>(HttpStatus.CREATED);
//		return ResponseEntity.ok("");
	}
}

class Request {

	public Request() {
	}

	private String title;
	private String url;
	private String text;

	@JsonProperty
	String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty
	String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty
	String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
