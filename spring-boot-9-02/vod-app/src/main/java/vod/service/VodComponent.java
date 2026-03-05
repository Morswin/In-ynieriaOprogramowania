package vod.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Exhibition;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final ExhibitionService exhibitionService;
    public VodComponent(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }
    @PostConstruct
    void init() {
        log.info("in post construct.");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Exhibition> exhibitions = exhibitionService.getAllExhibitions();
        log.info("{} exhibition found.", exhibitions.size());
        exhibitions.forEach(exhibition -> log.info("{}", exhibition));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("on context refreshed (from annotated method)");
    }
}
