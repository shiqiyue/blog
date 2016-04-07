package cn.wuwenyao.blog.site.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/***
 * {@link NotBlank}实现
 * @author 文尧
 *
 */
public class NotBlankValidator
        implements ConstraintValidator<NotBlank, CharSequence>
{
    @Override
    public void initialize(NotBlank annotation)
    {

    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context)
    {
        return StringUtils.isNotBlank(value);
    }
}
