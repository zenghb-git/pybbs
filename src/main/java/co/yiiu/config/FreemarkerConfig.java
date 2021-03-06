package co.yiiu.config;

import co.yiiu.config.properties.SiteConfig;
import co.yiiu.core.base.BaseEntity;
import co.yiiu.web.tag.*;
import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FreemarkerConfig {

  private Logger log = LoggerFactory.getLogger(FreemarkerConfig.class);

  @Autowired
  private freemarker.template.Configuration configuration;
  @Autowired
  private SiteConfig siteConfig;
  @Autowired
  private UserTopicDirective userTopicDirective;
  @Autowired
  private UserCommentDirective userCommentDirective;
  @Autowired
  private UserCollectDirective userCollectDirective;
  @Autowired
  private TopicsDirective topicsDirective;
  @Autowired
  private UserDirective userDirective;
  @Autowired
  private CurrentUserDirective currentUserDirective;
  @Autowired
  private NotificationsDirective notificationsDirective;
  @Autowired
  private CommentsDirective commentsDirective;
  @Autowired
  private ReputationDirective reputationDirective;
  @Autowired
  private BaseEntity baseEntity;
  @Autowired
  private SecurityTag securityTag;

  @PostConstruct
  public void setSharedVariable() throws TemplateModelException {
    // 注入全局配置至freemarker
    configuration.setSharedVariable("site", siteConfig);
    configuration.setSharedVariable("model", baseEntity);
    configuration.setSharedVariable("sec", securityTag);

    configuration.setSharedVariable("user_topics_tag", userTopicDirective);
    configuration.setSharedVariable("user_comments_tag", userCommentDirective);
    configuration.setSharedVariable("user_collects_tag", userCollectDirective);
    configuration.setSharedVariable("topics_tag", topicsDirective);
    configuration.setSharedVariable("user_tag", userDirective);
    configuration.setSharedVariable("current_user_tag", currentUserDirective);
    configuration.setSharedVariable("notifications_tag", notificationsDirective);
    configuration.setSharedVariable("comments_tag", commentsDirective);
    configuration.setSharedVariable("reputation_tag", reputationDirective);

    log.info("init freemarker sharedVariables {site} success...");
  }

}