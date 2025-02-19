---
layout: page
title: About
permalink: /about/
---
{% assign birth_year = 1988 %}
{% assign birth_month = 12 %}
{% assign birth_day = 18 %}

{% assign current_year = 'now' | date: "%Y" | plus: 0 %}
{% assign current_month = 'now' | date: "%m" | plus: 0 %}
{% assign current_day = 'now' | date: "%d" | plus: 0 %}

{% assign age = current_year | minus: birth_year %}
{% if current_month < birth_month %}
  {% assign age = age | minus: 1 %}
{% elsif current_month == birth_month %}
  {% if current_day < birth_day %}
    {% assign age = age | minus: 1 %}
  {% endif %}
{% endif %}

A professional and versatile software developer with a knack for problem-solving. Software developer experienced in Web, Mobile, Desktop, IT , and complex systems with high-performance requirements. Experienced Web Developer is adept in all stages of advanced web development. Able to effectively self-manage during independent projects and collaborate in a team setting:

## What is {{ site.url | remove: "https://" }}?

This is my home on the internet. The domain you are now contains my personal website & blog.
There is also other sub-domains, as:

- [mehmetaksahin.com](https://mehmetaksahin.com): My website

## My projets

will be listed here

## About the author

My name is Mehmet Aksahin, and I am {{ age }} years old. 
I'm currently working As a Senior Software Engineer Team Lead at Bitpace, I manage and mentor talented developers working on Bitpace and Koinal, two innovative products that provide secure and convenient solutions for cryptocurrency transactions. I have over ten years of experience in software development, focusing on web, mobile, desktop, IT, and complex systems with high-performance requirements.
I am proficient in Java, Spring Framework, microservice architecture, event-driven design, CQRS, SAGA patterns, and various cloud technologies, such as AWS, Kubernetes, Docker, and PostgreSQL. I also have Java, AWS, and Red Hat System Administration certifications. I am passionate about solving challenging problems, delivering quality code, and learning new technologies. My goal is to create value for my company and customers by developing scalable, reliable, and user-friendly applications that leverage the power of cryptocurrency.

### Friends

will be listed here
