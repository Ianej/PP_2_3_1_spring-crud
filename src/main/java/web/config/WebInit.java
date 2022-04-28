package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*Подытожу по проблеме кириллицы. Чтобы она везде правильно отображалась, нужно следать следующее:
    В классе наследнике AbstractAnnotationConfigDispatcherServletInitializer, в методе onStartup добавляем фильтр:
    //
    FilterRegistration.Dynamic encodingFilter = aContext.addFilter("encodingFilter", new CharacterEncodingFilter());
encodingFilter.setInitParameter("encoding", "UTF-8");
encodingFilter.setInitParameter("forceEncoding", "true");
encodingFilter.addMappingForUrlPatterns(null, true, "/*");

    ВАЖНО! Его нужно применять до других фильтров. Не знаю почему, но после HiddenHttpMethodFilter он у меня работать не захотел.
    */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
