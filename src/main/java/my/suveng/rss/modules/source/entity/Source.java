package my.suveng.rss.modules.source.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/22
 * description: rss订阅源
 **/
@Data
@Entity
public class Source {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) not null default ''")
    private String title;

    @Column(columnDefinition = "varchar(255) not null default ''")
    private String link;

    @Column(columnDefinition = "varchar(255) not null default ''")
    private String description;

    @Column(columnDefinition = "varchar(255) not null default ''")
    private String favicon;

    @Column(columnDefinition = "varchar(255) not null default ''")
    private String rssUrl;
 }
