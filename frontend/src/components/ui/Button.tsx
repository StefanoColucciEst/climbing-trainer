import type { ButtonHTMLAttributes } from 'react'

interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: 'primary' | 'secondary'
}

export function Button({ variant = 'primary', className = '', children, disabled, ...props }: ButtonProps) {
  const base = 'px-6 py-3 rounded-xl font-semibold text-sm transition-all duration-200'
  const variants = {
    primary: 'bg-gradient-to-r from-primary to-primary-dark text-white shadow-md active:scale-95 disabled:opacity-50',
    secondary: 'bg-white text-text border border-gray-200 shadow-sm active:scale-95 disabled:opacity-50',
  }
  return (
    <button className={`${base} ${variants[variant]} ${className}`} disabled={disabled} {...props}>
      {children}
    </button>
  )
}
